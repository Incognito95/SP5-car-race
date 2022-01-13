import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    useParams,
    useRouteMatch,
    NavLink
} from "react-router-dom";

import Login from "./Components/Login";

import React, { useState,useEffect } from "react";
import facade from "./ApiFacade";
import Menu from "./Components/Menu";
import Home from "./Components/Home";
import Races from "./Components/Races";
import SpecificHarbour from "./Components/SpecificHarbour";
import SpecificBoat from "./Components/SpecificBoat";

import NoMatch from "./Components/NoMatch";



function App() {
    const [loggedIn, setLoggedIn] = useState(false)
    const [userName, setUserName] = useState("")


    const logout = () => {
        // confused on how we get this to work as it's not being called
        facade.logout()
        setLoggedIn(false)
    }

    if (logout == true) {
        return "admin has logged out"
    }

    const login = (user, pass) => {
        setUserName(user);
        facade.login(user,pass)
            .then(res =>setLoggedIn(true));
    }

    if (login === true) {
        return "admin has logged in"
    }

    return (
        <div>
            {!loggedIn ? (<Login login={login} />) : (
                <div>
                    <Menu />
                    <Switch>
                        <Route exact path="/">
                            <Home />
                        </Route>
                        <Route exact path="/races">
                            <Races />
                        </Route>
                        <Route exact path="/specific-harbour">
                            <SpecificHarbour />
                        </Route>
                        <Route exact path="/specific-boat">
                            <SpecificBoat />
                        </Route>
                        <NoMatch />
                    </Switch>
                </div>
            )}
        </div>
    )

}



export default App;
