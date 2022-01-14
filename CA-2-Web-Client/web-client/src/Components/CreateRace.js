import { useState, useEffect } from "react";
import facade from "../ApiFacade";
import { useParams } from "react-router-dom";


const CreateRace = ({userName}) => {

    const [movies, setmovies] = useState([]); // show movie
    const [comments, setComments] = useState([]); // add rating
    const [comment, setComment] = useState({}); // show rating
    const [username, setUsername] = useState({}); // show username
    const [rating, setRating] = useState([]); // show rating

    let { id } = useParams();

    // create race
    const addComment = (event) => {
        event.preventDefault(); // prevent page from reloading after submitting form
        const body = {...comment};
        setUsername({body})
        facade.postData(body, "CreateRace").then(() => {
            facade.fetchData("races/" + id)
                .then(data => {
                    setComments(data);
                })
        })
    }

    // show races
    useEffect(() => {
        facade.fetchData("races")
            .then(data => {
                setComments(data);
                console.log(data.user);
            })
    }, [comment]);

    const changeComment = (event) => {
        event.preventDefault();
        setComment({ ...comment,[event.target.id]: event.target.value });
    }

    return (
        <div className="container mt-5 mb-5">
            <div className="row d-flex justify-content-center">

                <div className="comments">
                    <form onChange={changeComment}>
                        <h3>Create Race</h3>
                        <textarea name="comment" className="form-control mt-3" id="comment" cols="30" rows="10" name="comment"></textarea>
                        <button onClick={addComment} type="submit" className="btn btn-success mt-3 float-end">Send</button>
                    </form>
                </div>


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
                            comments.map((comment, index) => (
                                <tr>
                                    <td>{comment.race_id}</td>
                                    <td>{comment.race_name}</td>
                                    <td>{comment.date}</td>
                                    <td>{comment.time}</td>
                                    <td>{comment.location}</td>
                                </tr>
                            ))
                        }
                        </tbody>
                    </table>
                </div>

            </div>
        </div>

    )
}

export default CreateRace;