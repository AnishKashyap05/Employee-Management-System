import axios from "axios";

const EMPLOYEE_API_BASE_URL = 'http://localhost:8080'
class EmployeeService {
    saveEmployee(employee){
        return axios.post(`${EMPLOYEE_API_BASE_URL}/api/v1/employee`, employee)
    }

    getAllEmployees(){
        return axios.get(`${EMPLOYEE_API_BASE_URL}/api/v1/employees`)
    }

    deleteEmployee(id){
        return axios.delete(`${EMPLOYEE_API_BASE_URL}/api/v1/employee/${id}`)
    }

    getEmployeeById(id){
        return axios.get(`${EMPLOYEE_API_BASE_URL}/api/v1/employee/${id}`)
    }

    update(employee, id){
        return axios.post(`${EMPLOYEE_API_BASE_URL}/api/v1/employee/${id}`, employee)
    }
}

export default new EmployeeService();