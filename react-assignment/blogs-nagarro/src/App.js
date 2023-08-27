import { Route, Routes } from "react-router-dom";
import Nav from "./components/Nav";
import Add from "./Features/Add";
import Edit from "./Features/Edit";
import List from "./Features/List";
import View from "./Features/View";



function App() {
  return (
    <>
    <Nav/>
      <Routes>
      <Route exact path='/' element={<List/>}/>
      <Route exact path='/add' element={<Add/>}/>
      <Route exact path='/edit/:id' element={<Edit/>}/>
      <Route exact path='/view/:id' element={<View/>}/>
      
    </Routes>
    </>
  );
}

export default App;
