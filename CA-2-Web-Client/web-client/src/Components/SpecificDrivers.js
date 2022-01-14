import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const SpecificDrivers = () => {
    const [driverList, setDriverList] = useState([]);
    useEffect(() => {
        facade.fetchData("specific-drivers")
            .then(data => {
                setDriverList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>Drivers in a specific race</h2>

            <table className="table mt-4">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Birth Year</th>
                    <th>Gender</th>
                </tr>
                </thead>
                <tbody>
                {
                    driverList.map((driver, index) => (
                        <tr>
                            <td>{driver.driver_id}</td>
                            <td>{driver.driver_name}</td>
                            <td>{driver.birth_year}</td>
                            <td>{driver.gender}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}



export default SpecificDrivers;