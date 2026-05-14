import "./Admin.css";
import userIcon from "../../assets/images/UserElipse.svg";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/axios";

function MenuDatosAdmin() {

  const navigate = useNavigate();

  // =========================
  // MODOS
  // null | "ver" | "editar" | "preEditar" | "eliminar"
  // =========================
  const [modoUsuario, setModoUsuario] = useState(null);

  const [showBuscarUsuario, setShowBuscarUsuario] = useState(false);
  const [searchUsername, setSearchUsername] = useState("");

  const [usuario, setUsuario] = useState({
    nombre: "",
    apellido: "",
    email: "",
    username: "",
    roles: ""
  });

  const [direccion, setDireccion] = useState(null);

  const handleChange = (e) => {
    setUsuario({
      ...usuario,
      [e.target.name]: e.target.value
    });
  };

  // =========================
  // 🔍 VER USUARIO
  // =========================
  const handleOpenBuscarUsuario = () => {
    setShowBuscarUsuario(true);
    setModoUsuario("preVer");
    setSearchUsername("");
    setDireccion(null);
  };

  // =========================
  // ✏️ EDITAR USUARIO
  // =========================
  const handleEditarUsuario = () => {
    setShowBuscarUsuario(true);
    setModoUsuario("preEditar");
    setSearchUsername("");
    setDireccion(null);
  };

  // =========================
  // 🗑 ELIMINAR USUARIO (MISMO INPUT)
  // =========================
  const handleOpenEliminarUsuario = () => {
    setShowBuscarUsuario(true);
    setModoUsuario("eliminar");
    setSearchUsername("");
    setDireccion(null);
  };

  // =========================
  // 👤 BUSCAR USUARIO (VER / EDITAR / ELIMINAR)
  // =========================
  const handleBuscarUsuario = async () => {
    try {

      if (!searchUsername.trim()) {
        alert("Introduce un username");
        return;
      }

      const token = localStorage.getItem("token");

      // 🔥 SI ES ELIMINAR → no hace falta cargar usuario completo
      if (modoUsuario === "eliminar") {

        await api.delete(`/usuarioDelete/${searchUsername}`, {
          headers: { Authorization: `Bearer ${token}` }
        });

        alert("Usuario eliminado correctamente");

        setShowBuscarUsuario(false);
        setModoUsuario(null);
        return;
      }

      // =========================
      // VER / EDITAR
      // =========================
      const res = await api.get(
        `/miPerfil?username=${searchUsername}`,
        {
          headers: { Authorization: `Bearer ${token}` }
        }
      );

      setUsuario(res.data);
      setShowBuscarUsuario(false);

      if (modoUsuario === "preEditar") {
        setModoUsuario("editar");
        return;
      }

      setModoUsuario("ver");

      try {
        const direccionRes = await api.get(
          `/miDireccion?username=${searchUsername}`,
          {
            headers: { Authorization: `Bearer ${token}` }
          }
        );

        setDireccion(direccionRes.data);

      } catch (err) {
        setDireccion(null);
      }

    } catch (error) {
      alert("Usuario no encontrado");
      console.log(error);
    }
  };

  // =========================
  // 💾 GUARDAR USUARIO
  // =========================
  const handleSubmitUsuario = async (e) => {
    e.preventDefault();

    try {
      const token = localStorage.getItem("token");

      await api.put("/usuarioUpdate", usuario, {
        headers: { Authorization: `Bearer ${token}` }
      });

      alert("Usuario actualizado correctamente");
      setModoUsuario(null);

    } catch (error) {
      console.log(error);
      alert("Error al actualizar usuario");
    }
  };

  // =========================
  // 🚪 LOGOUT
  // =========================
  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("isLogged");
    localStorage.removeItem("role");

    navigate("/login");
  };

  return (
    <div className="usuarioPage">

      <div className="usuarioHeaderCenter">
        <img src={userIcon} alt="Admin" className="usuarioAvatar" />
      </div>

      <div className="opciones">

        <p onClick={handleOpenBuscarUsuario}>
          Ver usuario
        </p>

        <p onClick={handleEditarUsuario}>
          Modificar usuario
        </p>

        <p onClick={handleOpenEliminarUsuario}>
          Eliminar usuario
        </p>

        <p>Añadir producto</p>
        <p>Buscar producto</p>
        <p>Modificar producto</p>
        <p>Eliminar producto</p>

        <p className="logout" onClick={handleLogout}>
          Cerrar sesión
        </p>

      </div>

      {showBuscarUsuario && (
        <div className="formDireccion">

          <input
            type="text"
            placeholder="Introduce username"
            value={searchUsername}
            onChange={(e) => setSearchUsername(e.target.value)}
          />

          <button onClick={handleBuscarUsuario}>
            {modoUsuario === "eliminar" ? "Eliminar usuario" : "Buscar usuario"}
          </button>

        </div>
      )}

      {modoUsuario === "editar" && (
        <form onSubmit={handleSubmitUsuario} className="formDireccion">

          <input name="nombre" value={usuario.nombre} onChange={handleChange} />
          <input name="apellido" value={usuario.apellido} onChange={handleChange} />
          <input name="email" value={usuario.email} onChange={handleChange} />
          <input name="username" value={usuario.username} onChange={handleChange} />

          <button type="submit" className="cerrarSesion">
            Guardar cambios
          </button>

        </form>
      )}

      {modoUsuario === "ver" && (
        <div className="formDireccion">

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
            <p>No tiene dirección registrada</p>
          )}

        </div>
      )}

    </div>
  );
}

export default MenuDatosAdmin;