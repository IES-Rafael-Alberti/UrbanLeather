import "./Usuario.css";
import userIcon from "../../assets/images/UserElipse.svg";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import api from "../../api/axios";

function Usuario() {

  const navigate = useNavigate();
  const [usuario, setUsuario] = useState(null);

  useEffect(() => {

    const fetchUsuario = async () => {

      try {

        const token = localStorage.getItem("token");

        const response = await api.get("/miPerfil", {
          headers: {
            Authorization: `Bearer ${token}`
          }
        });

        setUsuario(response.data);

      } catch (error) {
        console.log(error);
      }
    };

    fetchUsuario();

  }, []);

  const handleLogout = () => {
    localStorage.removeItem("isLogged");
    localStorage.removeItem("token");
    navigate("/login");
  };

  const handleDatos = () => {

    // si es USER -> menú usuario
    if (usuario?.roles === "USER" || usuario?.roles?.includes("USER")) {
      navigate("/usuario/menuDatos");
    }

    // si es ADMIN -> pantalla normal
    else {
      navigate("/usuario/datos");
    }
  };

  return (
    <div className="usuarioPage">

      <div className="usuarioHeaderCenter">
        <img src={userIcon} alt="User" className="usuarioAvatar" />
      </div>

      <div className="opciones">

        <p onClick={handleDatos}>Datos</p>

        <p>Historial de compras</p>
        <p>Favoritos</p>
        <p>Opciones de pago</p>
        <p>Notificaciones</p>
        <p>Devoluciones y reembolsos</p>

        <button
          type="button"
          className="cerrarSesion"
          onClick={handleLogout}
        >
          Cerrar sesión
        </button>

      </div>

    </div>
  );
}

export default Usuario;