/**
 * '2019-11-20T07:27:52.000+0000' => 'dd.mm.yyyy'
 * @param {String} value 
 */
export function formatDate(strDate) {
  if (!strDate) return '';

  const date = new Date(strDate);
  let dd = date.getDate(),
      mm = date.getMonth() + 1,
      yy = date.getFullYear();
  
  if (dd < 10) dd = `0${dd}`;
  if (mm < 10) mm = `0${mm}`;

  return `${dd}.${mm}.${yy}`;  
}

/**
 * @param {number} status
 * @return {string} 
 */
export function pluralizationStatus(status) {
  if (status === 1) {
    return 'Опубликована';
  } else if (status === 2) {
    return 'Готова к публикации';
  } else if (status === 3) {
    return 'Черновик';
  } else if (status === 4) {
    return 'Удалина';
  }
  return '';
}

/**
 * @param {number} type
 * @return {string} 
 */
export function pluralizationType(type) {
  if (type === 1) {
    return 'Текст';
  } else if (type === 2) {
    return 'Новости';
  } else if (type === 3) {
    return 'Изображения';
  }
  return '';
}