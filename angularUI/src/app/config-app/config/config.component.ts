import { Component, OnInit } from '@angular/core';
import { RestConfigService } from '../rest-config.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})

export class ConfigComponent implements OnInit {
  
  constructor(public rest:RestConfigService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    
  }

}
