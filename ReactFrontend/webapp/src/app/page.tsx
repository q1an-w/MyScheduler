// pages/home.tsx
"use client";
import Head from "next/head";
import Navbar from "./components/navbar";
import { useState } from "react";
import { FiChevronDown, FiChevronUp } from "react-icons/fi"; // Assuming you're using React Icons

import "./home-styling/home.css"; // Importing the CSS file directly

const Home: React.FC = () => {
  return (
    <>
      <Navbar />{" "}
      <main className="main">
        <div className="resume">sdfgsdg</div>
      </main>
    </>
  );
};

export default Home;
