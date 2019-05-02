import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import { ReservaViaje } from './reserva-viaje';

@Injectable({
  providedIn: 'root'
})
export class ViajesApiService {
  endpoint = '/viajes-api/';
  httpOptions

  constructor(private http: HttpClient) { 
    
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
  }

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  getVuelosDisponibles(reserva:ReservaViaje): Observable<any> {
    return this.http.get(this.endpoint + 'vuelos/disponibles', {
      params: {
        origen: reserva.origen,
        destino: reserva.destino,
        fechaIda: reserva.fechaIda,
        fechaRegreso: reserva.fechaRegreso,
        nroPasajeros: reserva.nroPasajeros.toString(),
        clase: reserva.clase
      }
    }).pipe(
      map(this.extractData));
  }

  guardarReserva (reserva:ReservaViaje): Observable<ReservaViaje> {
    console.log(reserva);
    return this.http.post<ReservaViaje>(this.endpoint + 'reserva' , JSON.stringify(reserva), this.httpOptions).pipe(
      tap((reserva) => console.log(`reserva guardada w/ reserva=${reserva}`)),
      catchError(this.handleError<any>('guardarReserva'))
    );
  }
}
