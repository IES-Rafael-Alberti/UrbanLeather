import "./SeccionMujer.css";
import { useEffect, useState } from "react";
import api from "../../api/axios";

import heart from "../../assets/images/heart.svg";

function SeccionMujer() {

  const [productos, setProductos] = useState([]);

  // =========================
  // CARGAR PRODUCTOS BACKEND
  // =========================
  useEffect(() => {
    const fetchProductos = async () => {
      try {

        const res = await api.get("/productos");

        // =========================
        // FILTRAR SOLO MUJER
        // =========================
        const mujer = res.data.filter(
          (p) => p.categoriaNombre === "Mujer"
        );

        setProductos(mujer);

      } catch (error) {
        console.log("Error cargando productos:", error);
      }
    };

    fetchProductos();
  }, []);

  return (
    <div className="seccion-mujer">

      {/* TITULO */}
      <div className="titulo">
        <p>MUJER</p>
      </div>

      {/* PRODUCTOS */}
      <div className="chaquetas-container">

        {productos.map((item) => (
          <div className="chaqueta" key={item.id}>

            {/* IMAGEN DINÁMICA */}
            <img
              src={item.imagen_url}
              alt={item.nombre}
              className="chaqueta-img"
            />

            <div className="chaqueta-info">

              <p className="chaqueta-name">
                {item.nombre}
              </p>

              <p className="chaqueta-price">
                {item.precio}€
              </p>

              <img
                src={heart}
                alt="favorito"
                className="chaqueta-heart"
              />

            </div>
          </div>
        ))}

      </div>

    </div>
  );
}

export default SeccionMujer;