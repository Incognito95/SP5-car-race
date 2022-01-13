import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";
// import {Helmet} from "react-helmet";

const SpecificBoat = () => {
    const [boatList, setbBoatList] = useState([]);
    useEffect(() => {
        facade.fetchData("boat")
            .then(data => {
                setbBoatList(data);
            })
    }, []);

    const [ownerList, setOwnerList] = useState([]);
    useEffect(() => {
        facade.fetchData("owner")
            .then(data => {
                setOwnerList(data);
            })
    }, []);


    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>Owners Of Specific Boat</h2>
            <div className="btn-group float-end">
                <button className="btn btn-light dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    Select Boat
                </button>
                <ul className="dropdown-menu">
                    {
                        boatList.map((boat, index) => (
                            <li className="dropdown-item">{boat.name}</li>
                        ))
                    }
                </ul>
            </div>
            {/* importing the js boat filter file, using Helmet which takes plain HTML tags and outputs plain HTML tags. */}
            {/*<Helmet>*/}
            {/*    <script src="../boat-filter.js" type="text/javascript" />*/}
            {/*</Helmet>*/}

            <table className="table mt-4" id="boat-table">
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
                    ownerList.map((owner, index) => (
                        <tr>
                            <td>{owner.id}</td>
                            <td>{owner.name}</td>
                            <td>{owner.address}</td>
                            <td>{owner.phone}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}



export default SpecificBoat;