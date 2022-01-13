import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const SpecificHarbour = () => {
    const [harbourList, setHarbourList] = useState([]);
    useEffect(() => {
        facade.fetchData("harbour")
            .then(data => {
                setHarbourList(data);
            })
    }, []);

    const [boatList, setbBoatList] = useState([]);
    useEffect(() => {
        facade.fetchData("boat")
            .then(data => {
                setbBoatList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>Boats Belonging On Specific Harbour</h2>
            <div class="btn-group float-end">
                <button class="btn btn-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Select Harbour
                </button>
                <ul className="dropdown-menu">
                    {
                        harbourList.map((harbour, index) => (
                            <li className="dropdown-item">{harbour.name}</li>
                        ))
                    }
                </ul>
            </div>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone</th>
                </tr>
                </thead>
                <tbody>
                {
                    boatList.map((boat, index) => (
                        <tr>
                            <td>{boat.id}</td>
                            <td>{boat.brand}</td>
                            <td>{boat.make}</td>
                            <td>{boat.name}</td>
                            <td><img src={`/images/${boat.image}`} width="70" /></td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}



export default SpecificHarbour;