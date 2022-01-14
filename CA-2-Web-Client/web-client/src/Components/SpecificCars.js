import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";
// import {Helmet} from "react-helmet";

const SpecificCars = () => {
    const [carsList, setCarsList] = useState([]);
    useEffect(() => {
        facade.fetchData("specific-cars")
            .then(data => {
                setCarsList(data);
            })
    }, []);



    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>Cars belonging to a specific race</h2>

            <table className="table mt-4" id="boat-table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>Make</th>
                    <th>Year</th>
                </tr>
                </thead>
                <tbody>
                {
                    carsList.map((car, index) => (
                        <tr>
                            <td>{car.race_id}</td>
                            <td>{car.race_name}</td>
                            <td>{car.brand}</td>
                            <td>{car.make}</td>
                            <td>{car.car_year}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}



export default SpecificCars;