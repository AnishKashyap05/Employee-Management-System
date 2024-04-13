import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import EmployeeService from '../services/EmployeeService';
import Table from './Table';

function EmployeeList() {
    const navigate = useNavigate();

    const [employeeList, setEmployeeList] = useState([{}]);

    useEffect(()=>{
        const fetchData =async () =>{
            const response = await EmployeeService.getAllEmployees()
            setEmployeeList(response.data)
            console.log(response.data)
        } 
        fetchData();
    },[]);

    const deleteEmployee = (e, id) => {
        const response = EmployeeService.deleteEmployee(id).then((response) =>{
          setEmployeeList((prevEmployeeList) =>{
            return prevEmployeeList.filter((employee)=> employee.id != id)
          })
        });
        
      }

      const editEmployee = (e, id) => {
        e.preventDefault();
        navigate(`/editEmployee/${id}`)
      }

  return (
    <>
    <div className='container mx-auto my-8'>
    <div className='h-12 mb-5'>
        <button className='rounded bg-slate-600 text-white px-6 py-6' onClick={()=>navigate("/addEmployee")}> Add Employee</button>
    </div>


    <div className='flex shadow border-b'>
        <table className='min-w-full'>
            <thead className='bg-gray-50'>
                <tr className='text-left font-medium text-gray-500 uppercase tracking-wider py-3  px-6'>
                    <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3  px-6'> First Name</th>
                    <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3  px-6'> Last Name</th>
                    <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3  px-6'> Email Id</th>
                    <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3  px-6'>Actions</th>
                </tr>
            </thead>
            <tbody className='bg-white'>
                {employeeList.map(employee =>
                    <Table 
                    employee={employee}
                    deleteEmployee={deleteEmployee}
                    editEmployee={editEmployee}
                    />
                )}
            </tbody>
        </table>
    </div>

    </div>
    
    </>
    
  )
}

export default EmployeeList
