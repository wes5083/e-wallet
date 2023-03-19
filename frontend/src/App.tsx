import React from "react";
import "./App.css";
import Sidebar from "./components/menu/Sidebar";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage";
import WalletOpenPage from "./pages/wallet/WalletOpenPage";
import WalletTopUpPage from "./pages/wallet/WalletTopUpPage";
import WalletWithdrawPage from "./pages/wallet/WalletWithdrawPage";
import WalletTransactionPage from "./pages/wallet/WalletTransactionPage";

import Login from "./pages/Login";
import Register from "./pages/Register";
function App() {
  return (
    <BrowserRouter>
      <Sidebar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/wallets/open" element={<WalletOpenPage />} />
        <Route path="/wallets/topUp" element={<WalletTopUpPage />} />
        <Route path="/wallets/withdraw" element={<WalletWithdrawPage />} />
        <Route
          path="/wallets/transaction"
          element={<WalletTransactionPage />}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
