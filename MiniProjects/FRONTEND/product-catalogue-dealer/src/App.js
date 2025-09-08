import './App.css';
import DealerAddProduct from './components/DealerComponents/DealerAddProduct';
import LoginSignup from './components/LoginSignup/LoginSignup';
import AddProduct from './components/ProductsAdd/AddProduct';
// import { Routes, Route, Link } from 'react-router-dom';

import React from "react";
import { BrowserRouter as Router, Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";
// Home Page Component
const Home = () => {
    const navigate = useNavigate();
    return (
        <div>
            <h2>Home Page</h2>
            {/* <button onClick={() => navigate("/contact")}>Go to Contact</button> */}
        </div>
    );
};
// About Page Component 
const UserActions = () => (
    <div>
        <h2>UserActions Page</h2>
        <nav>
            <ul>
                <li>
                    <Link to="addproduct">Add Product</Link>
                </li>
                <li>
                    <Link to="company">Our Company</Link> 
                </li>
            </ul>
        </nav>
        <Outlet />
    </div>
);

// Components for other pages
const Contact = () => <h2>Contact Page</h2>;
const AddProcuct = () => <h2>AddProcuct Page</h2>;
const Company = () => <h2>Company Page</h2>;

function App() {
    return (
        <Router>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/useractions">UserActions</Link>
                    </li>
                    <li>
                        <Link to="/contact">Contact</Link>
                    </li>
                </ul>
            </nav>
            {/*Implementing Routes for respective Path */}
            <Routes>
                <Route path="/" element={<LoginSignup />} />
                <Route path="/useractions" element={<UserActions />}>
                <Route path="addproduct" element={<DealerAddProduct />} />
                <Route path="company" element={<Company />} />
                </Route>
                <Route path="/contact" element={<Contact />} />
            </Routes>
        </Router>
    );
}

export default App;