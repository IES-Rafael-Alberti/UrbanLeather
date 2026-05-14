import { Link, useLocation, useNavigate } from "react-router-dom";

import logo from "../../assets/images/Logo.png";
import search from "../../assets/images/search.svg";
import user from "../../assets/images/user.svg";
import userCheck from "../../assets/images/user-check.svg";
import bag from "../../assets/images/shopping-bag.svg";
import heart from "../../assets/images/heart.svg";
import menu from "../../assets/images/align-right.svg";
import arrow from "../../assets/images/arrow-left.svg";

import sortIcon from "../../assets/images/sort.svg";
import filterIcon from "../../assets/images/settings.svg";

import "./Header.css";

function Header() {
  const location = useLocation();
  const navigate = useNavigate();

  const isHome = location.pathname === "/";
  const isShop =
    location.pathname === "/hombre" || location.pathname === "/mujer";

  const isUser = location.pathname === "/usuario";

  const isLogged = localStorage.getItem("isLogged") === "true";
  const role = localStorage.getItem("role"); // 👈 AQUÍ ESTÁ LA CLAVE

  const handleUserClick = () => {
    if (!isLogged) {
      navigate("/login");
      return;
    }

    if (role === "ADMIN") {
      navigate("/admin/menu");
    } else {
      navigate("/usuario/menuDatos");
    }
  };

  return (
    <header className="header">

      <img src={logo} alt="Logo" />

      {isShop && (
        <div className="central">
          <div className="ordenar">
            <a className="sort">
              Sort by
              <img src={sortIcon} alt="sort" />
            </a>
          </div>

          <div className="filtrar">
            <a className="filter">
              Filter
              <img src={filterIcon} alt="filter" />
            </a>
          </div>
        </div>
      )}

      <div className="icons">

        {isShop && (
          <Link to="/">
            <img src={arrow} alt="back" />
          </Link>
        )}

        {isUser && (
          <Link to="/">
            <img src={arrow} alt="back" />
          </Link>
        )}

        <img src={search} alt="search" />

        {/* 👇 AQUÍ CAMBIA TODO */}
        <img
          src={isLogged ? userCheck : user}
          alt="user"
          onClick={handleUserClick}
          style={{ cursor: "pointer" }}
        />

        <img src={bag} alt="bag" />

        {isHome && (
          <>
            <img src={heart} alt="heart" />
            <img src={menu} alt="menu" />
          </>
        )}

      </div>
    </header>
  );
}

export default Header;