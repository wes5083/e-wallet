import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import LoginService from "../services/LoginService";
import { LoginUserProps } from "../interfaces/LoginUserProps";
import Swal from "sweetalert2";
import { setLoginUser } from "../utils/LocalUser";

const Login = () => {
  const navigate = useNavigate();
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e: any) => {
    e.preventDefault();
    LoginService.login(userName, password)
      .then((res) => {
        let status = res.status;
        let statusCode = res.data.statusCode;
        let errorMessage = res.data.message;
        if (status === 200 && statusCode === 1) {
          Swal.fire({
            icon: "success",
            title: "Login successfully!",
            showConfirmButton: false,
            timer: 3000,
          });
          let loginUser: LoginUserProps = {
            id: res.data.data.id,
            username: res.data.data.userName,
            type: res.data.data.type,
          };
          setLoginUser(loginUser);
          navigate("/");
        } else {
          Swal.fire({
            icon: "warning",
            title: errorMessage,
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
    <div className="d-flex flex-column h-100 w-100">
      <main className="d-flex align-items-center justify-content-center">
        <form>
          <div className="card-header">
            <div className="lead">Login</div>
          </div>
          <div className="card-body">
            <div className="mb-3">
              <label className="form-label">Login UserName</label>
              <input
                type="text"
                className="form-control"
                placeholder="Login UserName"
                onChange={(event) => setUserName(event.target.value)}
                required
              />
            </div>

            <div className="mb-3">
              <label className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                placeholder="Login password"
                onChange={(event) => setPassword(event.target.value)}
                required
              />
            </div>
          </div>
          <div className="card-foot d-grid gap-2">
            <button
              type="submit"
              className="btn btn-primary"
              onClick={handleSubmit}
            >
              Login
            </button>
            <p className="forgot-password text-right">
              Want to create account <Link to="/register">register?</Link>
            </p>
          </div>
        </form>
      </main>
    </div>
  );
};

export default Login;
