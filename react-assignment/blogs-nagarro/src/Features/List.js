import React from "react";
import "./List.css";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";

const List = () => {
  const blogs = useSelector((store) => store.blogs);

  const listFromLoacal = () =>
    blogs.map((blog) => (
      <>
        <li>
          {" "}
          <Link to={`/view/${blog.id}`}>{blog.title}</Link>
        </li>
      </>
    ));

  return (
    <>
      <div class="container-fluid p-5">
        <div class="row">
          <div class="col-lg-10 col-sm-10 ">
            <ol class="gradient-list w-75 pl-5">{listFromLoacal()}</ol>
          </div>

          <div className="col-lg-2 col-sm-2 ">
            <div className="p-3" style={{ border: "2px solid white" }}>
              <Link to={"/add"}>
                <button type="button" class="btn btn-primary btn-block">
                  Add Blog
                </button>{" "}
              </Link>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default List;
