import React from "react";
import { Link } from "react-router-dom";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import { useState } from "react";
import { deleteBlog } from "../reducers/blogReducer";
import { useDispatch } from "react-redux";

const View = () => {
  const navigate = useNavigate();
  const params = useParams();
  const blogs = useSelector((store) => store.blogs);
  const existingBlog = blogs.filter((blog) => blog.id === params.id);
  const [likeData, setLikedata] = useState("Like");
  const dispatch = useDispatch();

  const dataFromLoacal = () =>
    existingBlog.map((blog) => (
      <>
        <h2>Title: {blog.title} </h2>
        <hr></hr>
        <h4>Category: {blog.category}</h4>
        <hr></hr>
        <br></br>
        <p>Content: </p>
        <p>{blog.content}</p>
      </>
    ));

  const removeBlog = (id) => {
    dispatch(deleteBlog({ id: id }));
  };

  const likebutton = () => {
    switch (likeData) {
      case "Like":
        setLikedata("Unliked");

        break;
      case "Unliked":
        setLikedata("Like");
        break;
      default:
        setLikedata("Like");
    }
  };

  return (
    <>
      <div className="container-fluid p-5">
        <div className="row">
          <div className="col-lg-10 col-sm-10 " style={{ color: "white" }}>
            {dataFromLoacal()}
          </div>

          <div className="col-lg-2 col-sm-2 ">
            <div className="p-3" style={{ border: "2px solid white" }}>
              <Link to={"/"}>
                <button
                  type="button"
                  className="btn btn-primary btn-block mb-3"
                >
                  Back
                </button>
              </Link>

              <button
                type="button"
                className="btn bg-success btn-block mb-3"
                onClick={() => {
                  likebutton();
                }}
              >
                {likeData}
              </button>

              <Link to={`/edit/${params.id}`}>
                <button
                  type="button"
                  className="btn bg-dark btn-block mb-3"
                  style={{ color: "white" }}
                >
                  Edit Blog
                </button>
              </Link>
              <button
                className="btn btn-danger btn-block "
                onClick={() => {
                  removeBlog(params.id);
                  navigate("/");
                }}
              >
                Delete
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default View;
