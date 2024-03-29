import Footer from "../../components/Footer/Footer";
import NavBar from "../../components/NavBar";
import { Link } from "react-router-dom";
import "./Styles.css"

function Home() {
  return (
    <>
      <NavBar />
      <div className="container">
        <div className="jumbotron">
          <h1 className="display-4">DSVendas</h1>
          <p className="lead">Analise o desempenho das suas vendas por diferentes perspectivas</p>
          <hr/>
          <p>Esta aplicação consiste em exibir um dashboard a partir de dados fornecidos por um back end construído com Spring Boot.</p>
        </div>
        <Link to="/dashboard" className="btn btn-primary btn-lg btn-dboard">
          Acessar Dashboard
        </Link>
      </div>
      <Footer />
    </>
  );
}

export default Home;