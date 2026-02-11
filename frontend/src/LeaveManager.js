import React, { useEffect, useState } from "react";
import axios from "axios";

function LeaveManager() {
  const [name, setName] = useState("");
  const [type, setType] = useState("");
  const [leaves, setLeaves] = useState([]);

  useEffect(() => {
    fetchLeaves();
  }, []);

  const fetchLeaves = () => {
    axios.get("http://localhost:8080/leaves")
      .then(res => setLeaves(res.data));
  };

  const addLeave = () => {
    axios.post("http://localhost:8080/leaves", {
      employeeName: name,
      leaveType: type
    }).then(() => {
      fetchLeaves();
      setName("");
      setType("");
    });
  };

  const deleteLeave = (id) => {
    axios.delete(`http://localhost:8080/leaves/${id}`)
      .then(() => fetchLeaves());
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>LeaveMate – Employee Leave Manager</h2>

      <input
        placeholder="Employee Name"
        value={name}
        onChange={e => setName(e.target.value)}
      />

      <input
        placeholder="Leave Type"
        value={type}
        onChange={e => setType(e.target.value)}
      />

      <button onClick={addLeave}>Apply Leave</button>

      <ul>
        {leaves.map(leave => (
          <li key={leave.id}>
            {leave.employeeName} - {leave.leaveType} - {leave.status}
            <button onClick={() => deleteLeave(leave.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default LeaveManager;