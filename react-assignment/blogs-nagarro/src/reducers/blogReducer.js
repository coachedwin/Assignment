import { createSlice } from "@reduxjs/toolkit";

const initialState = [];

const blogReducer = createSlice({
  name: "blogs",
  initialState,
  reducers: {
    addBlog: (state, action) => {
      state.push(action.payload);
    },

    editBlog: (state, action) => {
      const { id, title, category, content } = action.payload;
      const existingBlog = state.find((blog) => blog.id === id);
      if (existingBlog) {
        existingBlog.title = title;
        existingBlog.category = category;
        existingBlog.content = content;
      }
    },

    deleteBlog: (state, action) => {
      const { id } = action.payload;
      const existingBlog = state.find((blog) => blog.id === id);
      if (existingBlog) {
        return state.filter((blog) => blog.id !== id);
      }
    },
  },
});

export default blogReducer.reducer;

export const { addBlog, editBlog, deleteBlog } = blogReducer.actions;
