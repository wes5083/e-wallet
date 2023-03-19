import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { WalletTransactionProps } from "../interfaces/WalletTransactionProps";
import WalletService from "../services/WalletService";
import { isLogined, getLoginUser } from "../utils/LocalUser";
import { LoginUserProps } from "../interfaces/LoginUserProps";

const HomePage = () => {
  const navigate = useNavigate();
  if (!isLogined()) {
    navigate("/login");
  }

  const [userName, setUserName] = useState<string>();
  const [amount, setAmount] = useState<string>();
  const [currency, setCurrency] = useState<string>();
  const [walletTransactionList, setWalletTransactionList] = useState<
    WalletTransactionProps[]
  >([]);
  const [isLoading, setIsLoading] = useState<boolean>(true);

  useEffect(() => {
    if (isLogined()) {
      handleQuery();
    }
  }, [isLoading]);

  const handleQuery = () => {
    WalletService.getWalletByUserId(getLoginUser().id)
      .then((res) => {
        if (res.status === 200 && res.data.statusCode === 1) {
          setUserName(res.data.data.userVo.userName);
          setAmount(res.data.data.balance);
          setCurrency(res.data.data.currency);
          setWalletTransactionList(res.data.data.walletTransactionVos);
          setIsLoading(false);
        }
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <div className="container">
        <div className="card">
          <div className="card-header">
            <div className="input-group">
              <label className="col-form-label">UserName: {userName}</label>
            </div>
            <div className="input-group">
              <label className="col-form-label">
                Amount: {amount} {currency}
              </label>
            </div>

            {isLogined() ? (
              <div className="input-group">
                <Link className="btn btn-outline-primary" to="/wallets/open">
                  Wallet Open
                </Link>
                &nbsp;&nbsp;
                <Link className="btn btn-outline-primary" to="/wallets/topUp">
                  Wallet TopUp
                </Link>
                &nbsp;&nbsp;
                <Link
                  className="btn btn-outline-primary"
                  to="/wallets/withdraw"
                >
                  Wallet Withdraw
                </Link>
                &nbsp;&nbsp;
                <Link
                  className="btn btn-outline-primary"
                  to="/wallets/transaction"
                >
                  Wallet Transaction
                </Link>
              </div>
            ) : (
              <Link className="btn btn-outline-primary" to="/login">
                login
              </Link>
            )}
          </div>
          <div className="card-body">
            <table className="table table-bordered">
              <thead>
                <tr>
                  <th>Index</th>
                  <th>TransType</th>
                  <th>TransAmount</th>
                  <th>TransTime</th>
                  <th>Comment</th>
                </tr>
              </thead>
              <tbody>
                {isLoading ? (
                  <div>loading......</div>
                ) : (
                  walletTransactionList &&
                  walletTransactionList.map(
                    (transaction: WalletTransactionProps, index: number) => {
                      return (
                        <tr key={index}>
                          <td>{index}</td>
                          <td>{transaction.transType}</td>
                          <td>{transaction.transAmount}</td>
                          <td>{transaction.transTime}</td>
                          <td>{transaction.comment}</td>
                        </tr>
                      );
                    }
                  )
                )}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
