export class Constants {
  /* Common Contants */
  public static readonly linkSeperator = '/';

  /* Mapping Contants */
  public static readonly indexMapping = '/index';
  public static readonly insertStudentMapping = '/student/insert';
  public static readonly insertTeacherMapping = '/teacher/insert';
  public static readonly insertTeacherStudentMapping = 'teacherStudent/insert';
  public static readonly updateStudentMapping = '/student/update';
  public static readonly updateTeacherMapping = '/teacher/update';
  public static readonly showAllStudentsMapping = '/student/showAll';
  public static readonly showAllTeachersMapping = '/teacher/showAll';
  public static readonly showAllTeacherStudentsMapping =
    '/teacherStudent/showAll';
  public static readonly showStudentFullDetailsMapping =
    '/student/showFullDetails';
  public static readonly showTeacherFullDetailsMapping =
    '/teacher/showFullDetails';
  public static readonly showStudentsByTeacherIdFormMapping =
    '/teacherStudent/showStudentsByTeacherIdForm';
  public static readonly showStudentsByTeacherIdMapping =
    '/teacherStudent/showStudentsByTeacherId';
  public static readonly showTeacherNameMapping = '/student/showTeacherName';

  /* Java Api Contants */
  public static readonly insertStudentApi = 'http://localhost:8080/tms/student';
  public static readonly updateStudentApi =
    'http://localhost:8080/tms/student/';
  public static readonly deleteStudentApi =
    'http://localhost:8080/tms/student/';
  public static readonly getAllStudentsApi =
    'http://localhost:8080/tms/student';
  public static readonly getStudentByIdApi =
    'http://localhost:8080/tms/student/';

  public static readonly insertTeacherApi = 'http://localhost:8080/tms/teacher';
  public static readonly updateTeacherApi =
    'http://localhost:8080/tms/teacher/';
  public static readonly deleteTeacherApi =
    'http://localhost:8080/tms/teacher/';
  public static readonly getAllTeachersApi =
    'http://localhost:8080/tms/teacher';
  public static readonly getTeacherByIdApi =
    'http://localhost:8080/tms/teacher/';

  public static readonly getStudentsByTeacherIdApi =
    'http://localhost:8080/tms/teacherStudent/students/';
  public static readonly getStudentsForMappingApi =
    'http://localhost:8080/tms/teacherStudent/mapping';
  public static readonly getTeacherForMappingApi =
    'http://localhost:8080/tms/teacherStudent/mapping/';
  public static readonly insertTeacherStudentApi =
    'http://localhost:8080/tms/teacherStudent';
  public static readonly getAllTeacherStudentsApi =
    'http://localhost:8080/tms/teacherStudent';
  public static readonly deleteTeacherStudentApi =
    'http://localhost:8080/tms/teacherStudent/';
  public static readonly getTeacherNameApi =
    'http://localhost:8080/tms/teacherStudent/teachers/';

  public static readonly contentType = 'application/json';
}
