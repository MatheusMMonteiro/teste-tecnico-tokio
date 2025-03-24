import React from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom'

import './App.css';

import Home from './view/home'
import About from './view/about'

function App() {
  return (
    <Router>
      <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
        </ul>
      </nav>
      
      <Route path="/" exact component={Home} />
      <Route path="/about" exact component={About} />
    </Router>
  );
}

export default App;
