import React, { useState } from 'react'
import EmployeeService from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const AddEmployee = () => {
   
    const [employeeDetails, setEmployeeDetails] = useState({
        firstName: "",
        lastName: "",
        emailId: "",
      });
    const updateEmployee = (e) => {
        const value = e.target.value;
        setEmployeeDetails({...employeeDetails, [e.target.name]: value});
    }

    const navigate = useNavigate();

    const saveEmployee =(e) =>{
        e.preventDefault();
        const response = EmployeeService.saveEmployee(employeeDetails).then((response)=>{
            navigate("/employeeList");
        });

    }

    const clearData = (e) =>{
        e.preventDefault();
        setEmployeeDetails({firstName:"",lastName:"",emailId:""});
    }

    return (
    <div className='flex max-w-2xl mx-auto shadow border-b'>
        <div className='px-8 py-8'>
            <div className='font-thin text-2xl tracking-wider'>
                <h1>Add New Employee</h1>
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
                 <input type='email' name="emailId" value={employeeDetails.email} onChange= {(e) => updateEmployee(e)} className='h-10 w-96 border mt-2'></input>   
            </div>

            <div className='item-center justify-center h-14 w-full my-4 pt-5'>
            <button className="bg-green-400 rounded text-white font-semibold py-2 px-6 hover:bg-green-700 mr-10" onClick={(e) => saveEmployee(e)}> Save </button>
            <button className="bg-red-400 rounded text-white font-semibold py-2 px-6 hover:bg-red-700" onClick={(e) => clearData(e)}> Clear </button>
            </div>
        </div>
    </div>
  )
}

export default AddEmployee
