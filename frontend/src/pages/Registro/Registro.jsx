import "./Registro.css";
import arrow from "../../assets/images/arrow-left-circle.svg";

import { useState } from "react";
import { useNavigate } from "react-router-dom";

import api from "../../api/axios";

function Registro() {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    nombre: "",
    apellido: "",
    email: "",
    username: "",
    password: "",
    repetirPassword: "",
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleRegister = async (e) => {
    e.preventDefault();

    try {

      const response = await api.post("/register", formData);

      alert(response.data);

      navigate("/login");

    } catch (error) {

      console.log(error);

      if (error.response) {
        alert(error.response.data.message);
      } else {
        alert("Error al conectar con el servidor");
      }
    }
  };

  return (
    <form className="formulario" onSubmit={handleRegister}>

      {/* Header registro */}
      <div className="headerRegistro">

        <p className="registrate">
          Regístrate
        </p>

        <a className="volver" href="/login">
          Volver
          <img src={arrow} alt="Volver" />
        </a>

      </div>

      {/* Formulario */}

      <input
        type="text"
        name="nombre"
        placeholder="Nombre"
        onChange={handleChange}
      />

      <input
        type="text"
        name="apellido"
        placeholder="Apellidos"
        onChange={handleChange}
      />

      <input
        type="text"
        name="username"
        placeholder="Nombre de usuario"
        onChange={handleChange}
      />

      <input
        type="email"
        name="email"
        placeholder="Correo electrónico"
        onChange={handleChange}
      />

      <input
        type="password"
        name="password"
        placeholder="Contraseña"
        onChange={handleChange}
      />

      <input
        type="password"
        name="repetirPassword"
        placeholder="Validar contraseña"
        onChange={handleChange}
      />

      <button type="submit" className="aceptar">
        Aceptar
      </button>

    </form>
  );
}

export default Registro;