import React from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { v4 as uuidv4 } from "uuid";
import { addBlog } from "../reducers/blogReducer";

const Add = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [values, setValues] = useState({
    title: "",
    category: "",
    content: "",
  });

  const addBlogHand = () => {
    setValues({ title: "", category: "", content: "" });
    dispatch(
        addBlog({
          id: uuidv4(),
          title: values.title,
          category: values.category,
          content: values.content,
        })
      );
    navigate("/");
  };

  return (
    <div class="container-fluid p-5">
      <div class="row">
        <div class="col-lg-10 col-sm-10 ">
          <div className="container  w-75 " style={{ color: "white" }}>
            <form
              className="form-group p-4"
              style={{ border: "2px solid white" }} onSubmit={addBlogHand}
            >
              <h4>Add New Blog</h4>
              <div className="form-outline mb-3">
                <label className="form-label" for="title">
                  Title
                </label>
                <input
                  required
                  typeof="text"
                  className="form-control"
                  onChange={(e) =>
                    setValues({ ...values, title: e.target.value })
                  }
                  value={values.title}
                />
              </div>
              <div className="form-outline mb-3">
                <label className="form-label" for="category">
                  Category
                </label>
                <input
                  required
                  typeof="text"
                  className="form-control"
                  onChange={(e) =>
                    setValues({ ...values, category: e.target.value })
                  }
                  value={values.category}
                />
              </div>
              <div className="form-outline mb-3">
                <label className="form-label" for="content">
                  Content
                </label>
                <textarea
                  rows="4"
                  required
                  typeof="text"
                  className="form-control"
                  onChange={(e) =>
                    setValues({ ...values, content: e.target.value })
                  }
                  value={values.content}
                />
              </div>
              <button
                typeof="submit"
                className="btn mr-3"
                style={{
                  background:
                    "linear-gradient(90deg, rgba(34,38,41,1) 0%, rgba(65,129,236,1) 98%)",
                  color: "white",
                }}
              >
                Submit
              </button>

              <button
                typeof="reset"
                className="btn"
                style={{
                  background:
                    "linear-gradient(90deg, rgba(34,38,41,1) 0%, rgba(236,234,65,1) 98%)",
                  color: "white",
                }}
                onClick={() => navigate("/")}
              >
                Cancel
              </button>
            </form>
          </div>
        </div>

        <div className="col-lg-2 col-sm-2 ">
          <div className="p-3" style={{ border: "2px solid white" }}>
            <Link to={"/"}>
              <button type="button" class="btn btn-primary btn-block">
                Go Back to list
              </button>{" "}
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Add;
