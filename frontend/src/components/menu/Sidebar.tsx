import React from "react";
import * as FaIcons from "react-icons/fa";
import { Link } from "react-router-dom";
import Header from "../header/Header";
import "./Sidebar.css";

const Navbar = () => {
  return (
    <>
      <div className="navbar">
        <Link to="#" className="menu-bars">
          <FaIcons.FaBars />
        </Link>
        <Header />
      </div>
    </>
  );
};

export default Navbar;
