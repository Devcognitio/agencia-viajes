import { Component, OnInit, Input } from '@angular/core';
import {Vuelo} from '../vuelo'
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-vuelos',
  templateUrl: './vuelos.component.html',
  styleUrls: ['./vuelos.component.css']
})
export class VuelosComponent implements OnInit {
  @Input() title: String;
  @Input() vuelo:Vuelo;

  constructor() { }

  ngOnInit() { }

}
