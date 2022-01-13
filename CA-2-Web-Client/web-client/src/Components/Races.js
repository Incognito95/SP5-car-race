import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const Races = () => {
    const [racesList, setRacesList] = useState([]);
    useEffect(() => {
        facade.fetchData("races")
            .then(data => {
                setRacesList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
            <div className="container mt-5">
                <h2>List Of Races</h2>
                        <table className="table mt-4">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Date</th>
                                    <th>Time</th>
                                    <th>Location</th>
                                </tr>
                            </thead>
                            <tbody>
                            {
                                racesList.map((race, index) => (
                                <tr>
                                    <td>{race.id}</td>
                                    <td>{race.name}</td>
                                    <td>{race.date}</td>
                                    <td>{race.time}</td>
                                    <td>{race.location}</td>
                                </tr>
                                ))
                            }
                        </tbody>
                </table>
            </div>
    )
}



export default Races;