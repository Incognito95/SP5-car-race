import {NavLink} from 'react-router-dom';
import React, {useEffect, useState} from "react";
import facade from "../ApiFacade";
import {forEach} from "react-bootstrap/ElementChildren";

function Menu () {

    const logout = () => { facade.logout() }

    return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
            <NavLink exact active className="navbar-brand" to="/"><img src="" width="60" /></NavLink>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="/">Home</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="/races">Races</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="/specific-cars">Cars</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="/specific-drivers">Drivers</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="btn btn-primary" to="/create-race">Create Race</NavLink>
                    </li>
                </ul>
                <form className="d-flex">
                    <NavLink exact active className="active nav-link text-black" to="#">

                    </NavLink>
                    <button onClick={logout} className="btn btn-success btn-logout">Logout</button>
                </form>
            </div>
        </div>
    </nav>
    )
}


export default Menu;