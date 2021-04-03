import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  empId ;
  constructor(private router :Router) {
    this.empId = localStorage.getItem("empId")
   }

  ngOnInit() {
  }
  loginValid(login)
  {
    var usr = localStorage.getItem("empId");
    console.log(usr);
    var pass = login.value.pass;
    if(usr == "1000" && pass == 1000)
    {
      console.log("Successfully login (1000)");
      this.router.navigate(['dashboard']);

    }
    else if (usr == "2000" && pass == 2000)
    {
      console.log("Successfully login (2000)");
      this.router.navigate(['dashboard']);
    }
    else if (usr == "2001" && pass == 2001)
    {
      console.log("Successfully login (2001)");
      this.router.navigate(['dashboard']);
    }
    else if (usr == "3000" && pass == 3000)
    {
      console.log("Successfully login (3000)");
      this.router.navigate(['dashboard']);
    }
    else if (usr == "3001" && pass == 3001)
    {
      console.log("Successfully login (3001)");
      this.router.navigate(['dashboard']);
    }
    else if (usr == "3002" && pass == 3002)
    {
      console.log("Successfully login (3002)");
      this.router.navigate(['dashboard']);
    }
    else if (usr == "3003" && pass == 3003)
    {
      console.log("Successfully login (3003)");
      this.router.navigate(['dashboard']);
    }
    else{
      alert("Invalid Password");
      
    }
  }

}
