import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import LoginService from "../services/LoginService";
import { UserProps } from "../interfaces/UserProps";
import { LoginUserProps } from "../interfaces/LoginUserProps";
import { UserType } from "../interfaces/Status";
import Swal from "sweetalert2";

import { setLoginUser } from "../utils/LocalUser";

function Register() {
  const navigate = useNavigate();

  const [userName, setUserName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [phone, setPhone] = useState("");

  const handleSubmit = (e: any) => {
    e.preventDefault();
    let registerUser: UserProps = {
      userName: userName,
      password: password,
      firstName: firstName,
      lastName: lastName,
      email: email,
      phone: phone,
      type: UserType.GENERAL,
      id: "",
    };
    LoginService.register(registerUser)
      .then((res) => {
        let status = res.status;
        let statusCode = res.data.statusCode;
        if (status === 200 && statusCode === 1) {
          Swal.fire({
            icon: "success",
            title: "Register successfully!",
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
    <div className="d-flex flex-column h-100 w-100">
      <main className="d-flex align-items-center justify-content-center">
        <form>
          <div className="card-header">
            <div className="lead">Register</div>
          </div>
          <div className="card-body">
            <div className="mb-3">
              <label className="form-label">UserName</label>
              <input
                type="text"
                className="form-control"
                placeholder="Login UserName"
                value={userName}
                onChange={(event) => setUserName(event.target.value)}
                required
              />
            </div>

            <div className="mb-3">
              <label className="form-label">Email</label>
              <input
                type="email"
                className="form-control"
                placeholder="Email"
                value={email}
                onChange={(event) => setEmail(event.target.value)}
                required
              />
            </div>

            <div className="mb-3">
              <label className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                placeholder="Login password"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
                required
              />
            </div>

            <div className="mb-3">
              <label className="form-label">First Name</label>
              <input
                type="text"
                className="form-control"
                placeholder="First Name"
                value={firstName}
                onChange={(event) => setFirstName(event.target.value)}
                required
              />
            </div>

            <div className="mb-3">
              <label className="form-label">Last Name</label>
              <input
                type="text"
                className="form-control"
                placeholder="Last Name"
                value={lastName}
                onChange={(event) => setLastName(event.target.value)}
                required
              />
            </div>

            <div className="mb-3">
              <label className="form-label">Phone</label>
              <input
                type="text"
                className="form-control"
                placeholder="Phone"
                value={phone}
                onChange={(event) => setPhone(event.target.value)}
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
              Register
            </button>
            <p className="forgot-password text-right">
              Already registered <Link to="/login">log in?</Link>
            </p>
          </div>
        </form>
      </main>
    </div>
  );
}

export default Register;
