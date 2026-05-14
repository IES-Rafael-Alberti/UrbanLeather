import "./Usuario.css";
import userIcon from "../../assets/images/UserElipse.svg";
import { useEffect, useState } from "react";
import api from "../../api/axios";

function DatosUsuario() {

  const [usuario, setUsuario] = useState(null);
  const [direccion, setDireccion] = useState(null);

  useEffect(() => {

    const fetchData = async () => {

      try {

        const token = localStorage.getItem("token");

        // =========================
        // USUARIO
        // =========================
        const userResponse = await api.get("/miPerfil", {
          headers: {
            Authorization: `Bearer ${token}`
          }
        });

        setUsuario(userResponse.data);

        // =========================
        // DIRECCIÓN
        // =========================
        try {
          const direccionResponse = await api.get("/miDireccion", {
            headers: {
              Authorization: `Bearer ${token}`
            }
          });

          setDireccion(direccionResponse.data);

        } catch (err) {
          // si no tiene dirección, simplemente no mostramos nada
          setDireccion(null);
        }

      } catch (error) {
        console.log(error);
      }
    };

    fetchData();

  }, []);

  if (!usuario) {
    return <p>Cargando datos...</p>;
  }

  return (
    <div className="usuarioPage">

      <div className="usuarioHeaderCenter">
        <img src={userIcon} alt="User" className="usuarioAvatar" />
      </div>

      <div className="opciones">

        <p>Nombre: {usuario.nombre}</p>
        <p>Apellido: {usuario.apellido}</p>
        <p>Email: {usuario.email}</p>
        <p>Username: {usuario.username}</p>
        <p>Rol: {usuario.roles}</p>

        <hr />

        {direccion ? (
          <>
            <p>📍 Dirección:</p>
            <p>{direccion.calle}, {direccion.numero}</p>
            <p>{direccion.cp} - {direccion.municipio}</p>
            <p>{direccion.provincia}</p>
          </>
        ) : (
          <p>No tienes dirección registrada</p>
        )}

      </div>

    </div>
  );
}

export default DatosUsuario;