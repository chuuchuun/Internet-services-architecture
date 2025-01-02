import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Universities } from '../model/universities';
import { University } from '../model/university';

@Injectable({
  providedIn: 'root',
})
export class UniversityService {
  constructor(private httpClient: HttpClient) {}

  getAllUniversities(): Observable<Universities> {
    return this.httpClient.get<Universities>('/api/universities');
  }

  getUniversityById(id: string): Observable<University> {
    return this.httpClient.get<University>(`/api/universities/${id}`);
  }

  createUniversity(university: University): Observable<University> {
    return this.httpClient.put<University>('/api/universities', university);
  }

  updateUniversity(university: University): Observable<University> {
    return this.httpClient.patch<University>(
      `/api/universities/${university.id}`,
      university,
    );
  }

  deleteUniversity(id: string): Observable<void> {
    return this.httpClient.delete<void>(`/api/universities/${id}`);
  }
}
