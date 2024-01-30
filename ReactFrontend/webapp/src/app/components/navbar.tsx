// components/Navbar.tsx

import Link from "next/link";
import "./component-styling/navbar.css";

const Navbar: React.FC = () => {
  return (
    <nav className="">
      <ul>
        <li>
          <Link href="/login">Login</Link>
        </li>
        <li>
          <Link href="/calendar">MyScheduler</Link>
        </li>
        <li>
          <Link href="/my-profile">About</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
