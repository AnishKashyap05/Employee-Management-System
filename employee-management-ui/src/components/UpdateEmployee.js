import React, { useEffect } from 'react'
import { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom'
import EmployeeService from '../services/EmployeeService';

const UpdateEmployee = () => {

  const {id} = useParams();

  const navigate = useNavigate();

  const [employeeDetails, setEmployeeDetails] = useState({
    id: id,
    firstName:"",
    lastName:"",
    emailId:"",
  });

  useEffect( () =>{
    const fetchData =async () =>{
        const response = await EmployeeService.getEmployeeById(id)
        setEmployeeDetails(response.data)
        console.log(response.data)
    } 
    fetchData();
  },[]);

  const updateEmployee = (e) => {
    const value = e.target.value;
    setEmployeeDetails({...employeeDetails, [e.target.name]: value});
}

const updateChanges =(e) =>{
    e.preventDefault();
    EmployeeService.update(employeeDetails, id).then((response)=>{
      console.log(response);
        navigate("/employeeList");
    });

}

const cancelUpdate = (e) =>{
    e.preventDefault();
    navigate("/employeeList");
}

  return (
    <div className='flex max-w-2xl mx-auto shadow border-b'>
        <div className='px-8 py-8'>
            <div className='font-thin text-2xl tracking-wider'>
                <h1>Update Employee</h1>
            </div>
            <div className='item-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'> First Name: </label>
                 <input type='text' name="firstName" value={employeeDetails.firstName} onChange= {(e) => updateEmployee(e)} className='h-10 w-96 border mt-2'></input>   
            </div>
            <div className='item-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'> Last Name: </label>
                 <input type='text' name="lastName" value={employeeDetails.lastName} onChange= {(e) => updateEmployee(e)} className='h-10 w-96 border mt-2'></input>   
            </div>
            <div className='item-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'> Email: </label>
                 <input type='email' name="emailId" value={employeeDetails.emailId} onChange= {(e) => updateEmployee(e)} className='h-10 w-96 border mt-2'></input>   
            </div>

            <div className='item-center justify-center h-14 w-full my-4 pt-5'>
            <button className="bg-green-400 rounded text-white font-semibold py-2 px-6 hover:bg-green-700 mr-10" onClick={(e) => updateChanges(e)}> Update </button>
            <button className="bg-red-400 rounded text-white font-semibold py-2 px-6 hover:bg-red-700" onClick={(e) => cancelUpdate(e)}> Cancel </button>
            </div>
        </div>
    </div>
  )
}

export default UpdateEmployee
