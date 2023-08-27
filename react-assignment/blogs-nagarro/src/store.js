import { configureStore } from "@reduxjs/toolkit";
import storage from "redux-persist/lib/storage";
import { combineReducers } from "redux";
import { persistReducer } from "redux-persist";
import blogReducer from "./reducers/blogReducer";

const reducers = combineReducers({
  blogs: blogReducer,
});

const persistConfig = {
  key: "blogs",
  storage,
};

const persistedReducer = persistReducer(persistConfig, reducers);

const store = configureStore({
  reducer: persistedReducer,
});

export { store };



