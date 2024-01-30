// pages/profile.tsx
"use client";
import Head from "next/head";
import Navbar from "../components/navbar";
import { useState } from "react";
import { FiChevronDown, FiChevronUp } from "react-icons/fi";

import "./profile-styling/profile.css";

const Home: React.FC = () => {
  const [isSectionVisible, setSectionVisibility] = useState<boolean[]>([]);

  const toggleSection = (index: number) => {
    setSectionVisibility((prevVisibility) => {
      const updatedVisibility = [...prevVisibility];
      updatedVisibility[index] = !updatedVisibility[index];
      return updatedVisibility;
    });
  };
  return (
    <div className="container">
      <Head>
        <title>Name</title>
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Navbar />

      <main className="main">
        <div className="resume">
          <div className="resume-header">
            <h1>Qian Yi Wang</h1>
            <p>Montreal, Qc</p>
            <p>(514)-702-9109</p>
            <p>
              <a href="https://www.linkedin.com/in/qian-yi-wang-0897471b4/">
                LinkedIn
              </a>{" "}
              – <a href="https://github.com/q1an-w">GitHub</a> –{" "}
              <a href="mailto:qianyi.wang02@gmail.com">
                qianyi.wang02@gmail.com
              </a>
            </p>
          </div>
          {/* SKILLS AND QUALIFICATIONS ---------------------------------------------- */}
          <div className="alternating-block">
            <h2 onClick={() => toggleSection(0)}>
              SKILLS AND QUALIFICATIONS{" "}
              {isSectionVisible[0] ? <FiChevronDown /> : <FiChevronUp />}
            </h2>
            {isSectionVisible[0] ? (
              <div>
                <p>Operating Systems: Windows – Linux – QNX</p>
                <p>
                  Software: Java – C++ – C# – JavaScript/TypeScript – HTML/CSS –
                  Python – Bash/PowerShell – React/Next/Vue – Spring Boot – .NET
                  – MongoDB – Dataverse – MySQL – Firebase
                </p>
                <p>
                  Hardware: VHDL – Intel x86 Assembly – LTSpice – Xilinx Vivado
                  Design Suite – Arduino – FPGA
                </p>
                <p>
                  Certifications: Intensive Cloud Computing – The Cloud Bootcamp
                  (GCP – AWS – IAM – GKE)
                </p>
                <p>
                  Miscellaneous: Ngrok – Postman – Android Studio – Putty –
                  MATLAB – JIRA – REST – gRPC – Microsoft SDK – Dynamics 365 –
                  Maven – Gradle – GitHub – Digital Ocean – GH pages – Docker –
                  Agile Methodology – MS Power Apps – Ngrok – Postman – Putty
                </p>
                <p>
                  Languages: French: spoken & written – English: spoken &
                  written – Mandarin: spoken
                </p>
              </div>
            ) : (
              <div></div>
            )}
          </div>
          {/* EDUCATION ---------------------------------------------- */}
          <div className="alternating-block">
            <h2 onClick={() => toggleSection(1)}>
              EDUCATION{" "}
              {isSectionVisible[1] ? <FiChevronDown /> : <FiChevronUp />}
            </h2>
            {isSectionVisible[1] ? (
              <div>
                <p>
                  Bachelor of Engineering – Computer Engineering (Co-Op)
                  [3.77/4.3 CGPA] 2021 – 2025 (Expected)
                </p>
                <p>Concordia University, Montreal, QC</p>
                <p>
                  Relevant Courses: Data Structures & Algorithms, Operating
                  Systems, Computer Architecture & Design, Real-Time Systems,
                  Digital System Design, Control systems, Networks & Protocols
                </p>
              </div>
            ) : (
              <div></div>
            )}
          </div>
          {/* WORK ---------------------------------------------- */}
          <div className="alternating-block">
            <h2 onClick={() => toggleSection(2)}>
              WORK EXPERIENCE{" "}
              {isSectionVisible[2] ? <FiChevronDown /> : <FiChevronUp />}
            </h2>
            {isSectionVisible[2] ? (
              <div>
                <p>
                  Software Development – SDK Specialist Intern (Jan 2024 –
                  Present)
                </p>
                <p>Genetec, Montreal, QC</p>
                <ul>
                  <li>
                    Assisted various partner’s efforts in integrating the
                    Security Center SDK for their specialized use case
                  </li>
                  <li>
                    Streamlined the certification process by developing a C# WPF
                    app that provides customizable testing configurations for
                    the SDK & the WebSDK
                  </li>
                  <li>
                    Developed on-demand features for the web portal using Vue JS
                    & SQL Elastic pools
                  </li>
                </ul>

                <p>AITS Service Desk Concordia (Apr 2023 – Sep 2023)</p>
                <p>Concordia University, Montreal, QC</p>
                <ul>
                  <li>
                    Oriented new students by issuing new ENCS accounts and by
                    providing general information.
                  </li>
                  <li>
                    Provided & setup staff and students with software licensing
                    & installation using Linux license eligibility tools.
                  </li>
                  <li>
                    Identified and resolved VPN, mail, and printer issues
                    through on-site assistance.
                  </li>
                  <li>
                    Enforced security through identity validation using Linux
                    inventory, network, and IP configuration tools.
                  </li>
                </ul>

                <p>
                  Software Development Intern (Digital Contact Center Platform –
                  DCCP) (Sep 2022 – Dec 2022)
                </p>
                <p>Nuance Communications, Montreal, QC</p>
                <ul>
                  <li>
                    Developed Active Call Tool dashboard displaying voice
                    biometrics, call history & action recommendations using
                    React TS and PowerApps.
                  </li>
                  <li>
                    Enabled seamless escalation from AI chatbot to live agent
                    using Microsoft’s Live chat, Voice & Video Calling SDKs.
                  </li>
                  <li>
                    Facilitated agent access to recommendations by creating a
                    custom tab in Dynamics 365 using Dataverse & PowerApps.
                  </li>
                </ul>
              </div>
            ) : (
              <div></div>
            )}
          </div>
          {/* PROJECTS ---------------------------------------------- */}
          <div className="alternating-block">
            <h2 onClick={() => toggleSection(3)}>
              PROJECTS{" "}
              {isSectionVisible[3] ? <FiChevronDown /> : <FiChevronUp />}
            </h2>
            {isSectionVisible[3] ? (
              <div>
                <p>MyScheduler / MVC WebApp (Nov 2023 – Present)</p>
                <p>Personal Project</p>
                <ul>
                  <li>
                    Full stack personal scheduler application with a custom
                    homepage & calendar for each user
                  </li>
                  <li>
                    Customized schedule event manipulation using Rest API
                    developed using Java Spring Boot and Firestore following
                    CRUD guidelines
                  </li>
                  <li>
                    Enhanced navigation experience by using Next TS to handle
                    server-side rendering & backend communication
                  </li>
                  <li>
                    Designed project architecture and navigation flow with
                    considerations for future features and scaling
                  </li>
                  <li>Hosted application & service using Firebase</li>
                </ul>

                <p>
                  ReTirely / Tire Shop Scheduling & Analytics Hackathon Project
                  (Jan 2024 – Jan 2024)
                </p>
                <p>
                  ConuHacks 2024 Concordia University Hackathon{" "}
                  <a href="https://github.com/q1an-w/Conu2024">GitHub Repo</a>
                </p>
                <ul>
                  <li>
                    Real-Time simulation & analytics of customer flow at a Tire
                    Changing store given a date range
                  </li>
                  <li>
                    Implemented a real-time algorithm for servicing decisions &
                    data reporting using Js
                  </li>
                  <li>
                    Designed & built a user-friendly frontend accepting a date
                    range to generate a total & day-by-day result using Next Js
                  </li>
                </ul>

                <p>
                  DrainFlow Solutions / Computer Engineering Product Design (Oct
                  2023 – Dec 2023)
                </p>
                <p>
                  Concordia University, Montreal, Qc{" "}
                  <a href="https://github.com/q1an-w/390">GitHub Repo</a>
                </p>
                <ul>
                  <li>
                    Android app + water flow and level sensors monitoring roof
                    water drains with real-time updates & notifications
                  </li>
                  <li>
                    Collected data in real-time by connecting water sensors to a
                    Raspberry Pi using LoRa modules
                  </li>
                  <li>
                    Implemented real-time monitoring and notification by
                    connection Firestore to both the Raspberry Pi and an Android
                    app
                  </li>
                  <li>
                    Led & initiated project development as product owner by
                    synthesizing investor needs into User Stories
                  </li>
                  <li>
                    Designed project architecture and flow to facilitate both
                    team coordination & meeting design goals
                  </li>
                  <li>
                    Ensured smooth development progress through weekly team
                    meetings, task & sprint backlog management by assigning
                    tasks based on individual ability, initiative, and task
                    priority
                  </li>
                </ul>

                <p>
                  Model CPU / Computer Architecture & Design Project (Oct 2023 –
                  Dec 2023)
                </p>
                <p>Concordia University, Montreal, Qc</p>
                <ul>
                  <li>
                    32-bit CPU designed in VHDL & tested on 4-bit FPGA board
                    using bit-casting
                  </li>
                  <li>
                    Designed a functional 32-bit CPU composed of an ALU, a
                    program counter, 32 registers, a data path & an instruction
                    cache using the Xilinx Vivado IDE
                  </li>
                  <li>
                    Implemented support for 32-bit machine code instructions
                    using VHDL, supporting Immediate, Register and Direct
                    addressing
                  </li>
                  <li>
                    Ensured proper functionality by monitoring the CPU state
                    step-by-step using Modelsim & a comprehensive set of test
                    instructions
                  </li>
                </ul>

                <p>
                  Aircraft Monitoring System (AMS) / Real-Time System Project
                  (Oct 2023 – Dec 2023)
                </p>
                <p>Concordia University, Montreal, Qc</p>
                <ul>
                  <li>
                    The AMS is a real-time solution for small aircraft,
                    providing a dashboard to monitor critical system parameters
                  </li>
                  <li>
                    Implemented multi-threaded architecture using QNX and Unix
                    threads for efficient sensor data polling
                  </li>
                  <li>
                    Successfully simulated smoke detection scenarios and
                    recorded sensor readings with timestamps using C++
                  </li>
                  <li>
                    Designed user-friendly interface featuring dials, warning
                    lamps, and CRT display with keyboard support
                  </li>
                  <li>
                    Prioritized task scheduling based on threat level to ensure
                    a timely response
                  </li>
                </ul>

                <p>
                  Drive Up / Delivery Load – Driver Assignment Hackathon Project
                  (Nov 2023 – Nov 2023)
                </p>
                <p>CodeJam 2023 McGill University Hackathon</p>
                <ul>
                  <li>
                    Mobile webapp connecting truck drivers & packages based on
                    location, delivery distance & preferences.
                  </li>
                  <li>
                    Revealed packages to nearby truckers based on preferences
                    using Next JS & MQTT data
                  </li>
                  <li>
                    Supplemented notifications pipeline with suggestions based
                    on partial preference matches
                  </li>
                  <li>
                    Presented relevant information for both truckers and admins
                    using the Google Maps API
                  </li>
                </ul>

                <p>
                  Co-Operation / Job finding Website [A+] (Jan 2023 – Apr 2023)
                </p>
                <p>Concordia University, Montreal, QC</p>
                <ul>
                  <li>
                    Full stack job finding website where employers and
                    candidates could both sign up/login, view candidates, CRUD
                    job postings, as well as view and apply to jobs
                    respectively.
                  </li>
                  <li>
                    Designed project architecture and use case diagrams as
                    software lead using draw.io
                  </li>
                  <li>
                    Brought teammates up to speed with the tech stack (React,
                    Express, Rest API, Deployment Pipeline, CI)
                  </li>
                  <li>
                    Planned and created Stories each Sprint using GitHub Issues
                  </li>
                  <li>
                    Achieved multi-page functionality through a single-page
                    website using React Hash Router
                  </li>
                </ul>

                <p>
                  Hovercraft Design / Engineering Team Design Project (Jan 2023
                  – Apr 2023)
                </p>
                <p>Concordia University, Montreal, QC</p>
                <ul>
                  <li>
                    Design and construct an autonomous hovercraft to enter a
                    competition scored based on distance traveled, time taken to
                    travel and number of parts used.
                  </li>
                  <li>
                    Selected design by creating several models and conducting
                    SWOT & AHP analysis to determine the best match
                  </li>
                  <li>
                    Designed & implemented hovercraft navigation algorithm using
                    Arduino
                  </li>
                  <li>
                    Finalized design during construction by adding some
                    necessary modifications to the design
                  </li>
                  <li>
                    Led weekly meetings with team members for progress tracking
                    using Gantt charts and task separation
                  </li>
                  <li>
                    Mediated and resolved team member conflicts in an
                    appropriate and timely manner
                  </li>
                </ul>
              </div>
            ) : (
              <div></div>
            )}
          </div>
          {/* AWARDS ---------------------------------------------- */}
          <div className="alternating-block">
            <h2 onClick={() => toggleSection(4)}>
              AWARDS AND DISTINCTIONS{" "}
              {isSectionVisible[4] ? <FiChevronDown /> : <FiChevronUp />}
            </h2>
            {isSectionVisible[4] ? (
              <div>
                <ul>
                  <li>
                    Dean’s Honor Roll student (Concordia University) 2021 – 2023
                  </li>
                  <li>
                    Hydro-Quebec Entrance Scholarship (Concordia University)
                    2021
                  </li>
                  <li>Dean’s Honor Roll student (Vanier) 2020 – 2021</li>
                </ul>
              </div>
            ) : (
              <div></div>
            )}
          </div>
          <div className="alternating-block"></div>
        </div>
      </main>
    </div>
  );
};

export default Home;
