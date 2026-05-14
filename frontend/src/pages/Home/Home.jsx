import { Link } from "react-router-dom";
import "./Home.css";
import Header from "../../components/Header/Header";
import rectangle from "../../assets/images/rectangle.png";

function Home() {
  return (
    <>
      <div className="generos">
        <Link to="/hombre">
          <p>HOMBRE</p>
        </Link>

        <Link to="/mujer">
          <p>MUJER</p>
        </Link>
      </div>

      <div className="rectangle">
        <img src={rectangle} alt="banner" />
      </div>
    </>
  );
}

export default Home;