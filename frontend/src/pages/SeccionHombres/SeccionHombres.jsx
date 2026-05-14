import "./SeccionHombres.css";
import { useEffect, useState } from "react";
import api from "../../api/axios";

import heart from "../../assets/images/heart.svg";

function SeccionHombres() {

  const [productos, setProductos] = useState([]);

  // =========================
  // CARGAR PRODUCTOS BACKEND
  // =========================
  useEffect(() => {
    const fetchProductos = async () => {
      try {
        const res = await api.get("/productos");

        // Filtrar SOLO HOMBRE
        const hombres = res.data.filter(
          (p) => p.categoriaNombre === "Hombre"
        );

        setProductos(hombres);

      } catch (error) {
        console.log("Error cargando productos:", error);
      }
    };

    fetchProductos();
  }, []);

  return (
    <div className="seccion-hombres">

      <div className="titulo">
        <p>HOMBRE</p>
      </div>

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

export default SeccionHombres;