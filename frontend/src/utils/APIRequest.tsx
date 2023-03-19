import axios from "axios";
import { API_SERVER_URL } from "./Config";

const config = {
  baseURL: API_SERVER_URL,
  headers: {
    "Access-Control-Allow-Headers": "*",
    "Access-Control-Allow-Origin": `${API_SERVER_URL}`,
    "content-Type": "application/json",
  },
};
const APIRequest = axios.create(config);

APIRequest.interceptors.request.use(async (con) => {
  return con;
});

APIRequest.interceptors.response.use(
  (response) => {
    console.log("APIRequest response: " + JSON.stringify(response));
    return response;
  },

  (error) => {
    return error.response;
  }
);

export default APIRequest;
