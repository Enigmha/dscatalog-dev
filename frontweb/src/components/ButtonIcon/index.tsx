import './styles.css';
import './styles.css';
import { ReactComponent as SetaIcon } from 'assets/images/Seta.svg';

const ButtonIcon = () => {
  return (
    <div className="btn-container">
      <button className="btn btn-primary">
        <h6>INICIE AGORA A SUA BUSCA</h6>
      </button>

      <div className="btn-icon-container">
        <SetaIcon />
      </div>
    </div>
  );
};
export default ButtonIcon;
