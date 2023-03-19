import APIRequest from "../utils/APIRequest";
import { UserProps } from "../interfaces/UserProps";

const LoginService = {
  login: (username: string, password: string) => {
    const url = `/api/users/login`;
    const params = {
      userName: username,
      password: password,
    };
    return APIRequest.post(url, params);
  },
  logout: (username: string) => {
    const url = `/api/users/logout`;
    const params = {
      userName: username,
    };
    return APIRequest.post(url, params);
  },
  register: (params: UserProps) => {
    const url = `/api/users/register`;
    return APIRequest.post(url, params);
  },
};
export default LoginService;
