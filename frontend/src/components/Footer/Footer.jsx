import instagram from "../../assets/images/instagram.svg";
import twitter from "../../assets/images/twitter.svg";
import facebook from "../../assets/images/facebook.svg";
import youtube from "../../assets/images/youtube.svg";
import pinterest from "../../assets/images/pinterest.svg";
import tiktok from "../../assets/images/tiktok.svg";
import "./Footer.css";

function Footer() {
  return (
    <div className="footer">
      <div className="footer-column">
        <p>Sobre nosotros</p>
        <p>Contactos</p>
      </div>

      <div className="footer-column">
        <p>Preguntas frecuentes</p>
        <p>Política de envíos</p>
      </div>

      <div className="footer-column">
        <p>Información legal</p>
        <p>Suscripciones</p>
      </div>

      <div className="footer-icons">
        <img src={instagram} alt="instagram" />
        <img src={twitter} alt="twitter" />
        <img src={facebook} alt="facebook" />
        <img src={youtube} alt="youtube" />
        <img src={pinterest} alt="pinterest" />
        <img src={tiktok} alt="tiktok" />
      </div>
    </div>
  );
}

export default Footer;