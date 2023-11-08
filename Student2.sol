pragma solidity ^0.8.0;

contract StudentData {
    
    struct Student {
        uint256 id;
        string name;
        uint256 age;
        string major;
    }

    // Array to store student data
    Student[] public students;

    // Add a new student
    function addStudent(uint256 _id, string memory _name, uint256 _age, string memory _major) public {
        students.push(Student(_id, _name, _age, _major));
    }

    // Get the total number of students
    function getStudentCount() public view returns (uint256) {
        return students.length;
    }

    // Get student data by index
    function getStudent(uint256 index) public view returns (uint256, string memory, uint256, string memory) {
        require(index < students.length, "Invalid index");
        Student memory student = students[index];
        return (student.id, student.name, student.age, student.major);
    }

    // Fallback function to receive Ether
    receive() external payable {
        // This function can be used to receive Ether transactions
    }
}
