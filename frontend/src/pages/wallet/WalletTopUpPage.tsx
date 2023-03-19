import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";
import WalletService from "../../services/WalletService";
import { getLoginUser } from "../../utils/LocalUser";
import { LoginUserProps } from "../../interfaces/LoginUserProps";

const WalletTopUpPage = () => {
  const navigate = useNavigate();
  const loginUser: LoginUserProps = getLoginUser();
  const loginUserid = loginUser.id;
  const [amount, setAmount] = useState<string>("");

  const handleSave = () => {
    WalletService.topUpByUserId(loginUserid, amount)
      .then((res) => {
        if (res.status === 200 && res.data.statusCode === 1) {
          Swal.fire({
            icon: "success",
            title: "Operate successfully!",
            showConfirmButton: false,
            timer: 3000,
          });
          navigate("/");
        } else {
          Swal.fire({
            icon: "warning",
            title: res.data.message,
            showConfirmButton: false,
            timer: 3000,
          });
          return false;
        }
      })
      .catch(function (error) {
        Swal.fire({
          icon: "error",
          title: "An Error Occured!",
          showConfirmButton: false,
          timer: 3000,
        });
      });
  };

  return (
    <>
      <div className="container">
        <h2 className="text-center mt-5 mb-3">Wallet TopUp</h2>
        <div className="card">
          <div className="card-header">
            <Link className="btn btn-outline-info float-right" to="/">
              Back
            </Link>
          </div>
          <div className="card-body">
            <form>
              <div className="form-group">
                <label htmlFor="amount">TopUp Amount</label>
                <input
                  onChange={(event) => {
                    setAmount(event.target.value);
                  }}
                  defaultValue={amount}
                  type="text"
                  className="form-control"
                  id="amount"
                  name="amount"
                />
              </div>

              <button
                onClick={handleSave}
                type="button"
                className="btn btn-outline-primary mt-3"
              >
                Wallet ToUp
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default WalletTopUpPage;
