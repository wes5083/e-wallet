import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";
import WalletService from "../../services/WalletService";
import { getLoginUser } from "../../utils/LocalUser";
import { LoginUserProps } from "../../interfaces/LoginUserProps";

const WalletOpenPage = () => {
  const navigate = useNavigate();
  const loginUser: LoginUserProps = getLoginUser();
  const loginUserid = loginUser.id;
  const [currency, setCurrency] = useState<string>("");
  const [isSaving, setIsSaving] = useState(false);

  const handleSave = () => {
    setIsSaving(true);

    WalletService.openWalletByUserId(loginUserid, currency)
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
          setIsSaving(false);
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
        setIsSaving(false);
      });
  };

  return (
    <>
      <div className="container">
        <h2 className="text-center mt-5 mb-3">Wallet Open</h2>
        <div className="card">
          <div className="card-header">
            <Link className="btn btn-outline-info float-right" to="/">
              Back
            </Link>
          </div>
          <div className="card-body">
            <form>
              <div className="form-group">
                <label htmlFor="currency">Currency</label>
                <input
                  onChange={(event) => {
                    setCurrency(event.target.value);
                  }}
                  defaultValue={currency}
                  type="text"
                  className="form-control"
                  id="currency"
                  name="currency"
                />
              </div>

              <button
                disabled={isSaving}
                onClick={handleSave}
                type="button"
                className="btn btn-outline-primary mt-3"
              >
                Wallet Open
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default WalletOpenPage;
