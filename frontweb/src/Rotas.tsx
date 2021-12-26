import Navbar from 'components/Navbar';
import { Routes, Route } from 'react-router-dom';
import { BrowserRouter } from 'react-router-dom';
import Home from 'pages/Home'; 
import Catalog from 'pages/Catalog';
import Admin from 'pages/Admin';

const Rotas = () => (
    <BrowserRouter>
        <Navbar />
        <Routes>
            <Route path= '/' element={<Home />} />
        </Routes>
        <Routes>
            <Route path= '/products' element={<Catalog />} />
        </Routes>
        <Routes>
            <Route path= '/admin' element={<Admin />} />
        </Routes>
        
    
    </BrowserRouter>
);

export default Rotas;
