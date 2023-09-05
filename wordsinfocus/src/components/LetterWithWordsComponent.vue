<template>
    <div class="container">
        <div class="split left">
            <div class="top">
                <h1 class="letter">{{ this.letter.name }}  </h1>
            </div>
            <div class="bottom">
               <div class="search">
                <input type="text" class="searchInput" placeholder="Пребарај збор"/>
               </div>
               <div>
                <select name="words" id="words" class="wordsDropdown"  @change="getSelectedWordId($event)" >
                    <option selected disabled>Одбери збор</option>
                    <option v-for="word in words" v-bind:key="word.id" v-bind:value="word.id">{{word.word}}</option>
                </select>
               </div>
            </div>
        </div>
        <div class="split right">
            <div>
                <WordComponent  :wordId="selectedWordId" :letter="this.letter" :word="this.word"></WordComponent>
            </div>
        </div>
    </div>
</template>

<script>

import WordComponent from './WordComponent.vue';

    export default{
    name: "LetterWithWordsComponent",
    data() {
        return {
            name: this.$route.params.l,
            letter: null,
            words: [],
            selectedWordId: 0,
            word:null
            
        };
    },
    methods: {
        async getLetter() {
            const letterApi = await fetch('http://localhost:9090/api/letters/byName/' +this.name);
            const result = await letterApi.json();
            this.letter = result;
        },
        async getWords() {
            const wordsApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words');
            const result = await wordsApi.json();
            this.words = result;
            this.word=result[0];
            this.selectedWordId = result[0].id;
        },
        async getSelectedWordId(event){
                console.log(event.target.value);
                this.selectedWordId =  event.target.value;
                const wordApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words/' + event.target.value);
                const result = await wordApi.json();
                console.log(result)
                this.word = result;
                console.log(this.word)
                // this.$forceUpdate();
            
            }
         
    },
    computed:{
       
    },
    beforeMount(){
        this.getLetter();
        this.getWords();
    },
    components:{
        WordComponent
    }
}

</script>

<style scoped>
.container {
    height: 80vh;
}

.letter{
    background-color: whitesmoke;
    display: inline-block;
    min-width: 80px;
    padding: 40px;
    margin-top: 98px;
    font-size:xx-large;
    font-size: 50px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
}
.left {

  display: block;
  float: left;
  width: 30%;
  height: 100%;
}

.right {
    display: block;
  /* background-color: #22a30b; */
  float: left;
  width: 70%;
  height: 100%;
}

.top{
    height: 35%;
    width: 100%;
    
}

.bottom{
    height: 65%;
    /* background-color: pink; */
}

.wordsDropdown{
    font-size:xx-large;
    font-size: 20px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
    background-color: whitesmoke;
    text-align: center;
    width: 280px;
}

.searchInput{
    font-size: 17px;
    box-shadow: 5px 5px 10px 0px;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
    background-color: whitesmoke;
    text-align: center;
    width: 272px;
    height: 22px;
    margin-bottom: 10px;
}

</style>