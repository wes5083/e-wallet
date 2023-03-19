import { Link, useNavigate } from "react-router-dom";
import * as ImIcons from "react-icons/im";
import * as FiIcons from "react-icons/fi";
import * as BiIcons from "react-icons/bi";
import "./Header.css";
import { isLogined, getLoginUser, clearLoginUser } from "../../utils/LocalUser";
import { LoginUserProps } from "../../interfaces/LoginUserProps";
const Header = () => {
  const loginUser: LoginUserProps = getLoginUser();
  const navigate = useNavigate();
  return (
    <div>
      <ul className="header">
        <li>
          <Link to="/">
            <ImIcons.ImHome />
          </Link>
        </li>
        <li>
          <Link to="/register">
            <BiIcons.BiRegistered />
          </Link>
        </li>
        <li>
          {isLogined() ? (
            <a
              href="#"
              onClick={() => {
                clearLoginUser();
                navigate("/login");
              }}
            >
              <FiIcons.FiLogOut />
            </a>
          ) : (
            <Link to="/login">
              <FiIcons.FiLogIn />
            </Link>
          )}
        </li>
      </ul>
    </div>
  );
};

export default Header;
